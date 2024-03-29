package br.com.stingelin.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.stingelin.data.vo.v1.BookVO;
import br.com.stingelin.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Book Endpoint", description = "Make operations for Book Endpoint", tags = {"BookEndpoint"})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	private BookServices service;

	@Autowired
	private PagedResourcesAssembler<BookVO> assembler;

    @ApiOperation(value = "Find all books recorded")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(
		@RequestParam(value = "page", defaultValue = "0") int page,
		@RequestParam(value = "limit", defaultValue = "12") int limit,
		@RequestParam(value = "direction", defaultValue = "asc") String direction
	) {
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "title"));
		Page<BookVO> list = service.findAll(pageable);
		list
			.stream()
			.forEach(el -> el.add(
				linkTo(
					methodOn(BookController.class).findById(el.getKey())
				).withSelfRel()
			));
		PagedResources<?> resources = assembler.toResource(list);

		return new ResponseEntity<>(resources, HttpStatus.OK);
	}

    @ApiOperation(value = "Find book by id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO bookVO = service.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}

    @ApiOperation(value = "Save book received in the body")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO create(@RequestBody BookVO person) {
		BookVO bookVO = service.create(person);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}

    
    @ApiOperation(value = "Update book received in the body")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO update(@RequestBody BookVO person) {
		BookVO bookVO = service.update(person);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}

    
    @ApiOperation(value = "Delete book by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}