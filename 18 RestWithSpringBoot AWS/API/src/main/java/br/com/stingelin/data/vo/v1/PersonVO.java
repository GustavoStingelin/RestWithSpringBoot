package br.com.stingelin.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import org.springframework.hateoas.ResourceSupport;

@JsonPropertyOrder({ "id", "firstName", "lastName", "address", "gender", "enabled" })
public class PersonVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;

	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	private Boolean enabled;

	public PersonVO() {
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean isEnabled() {
		return this.enabled;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PersonVO)) {
			return false;
		}
		PersonVO personVO = (PersonVO) o;
		return Objects.equals(key, personVO.key) && Objects.equals(firstName, personVO.firstName)
				&& Objects.equals(lastName, personVO.lastName) && Objects.equals(address, personVO.address)
				&& Objects.equals(gender, personVO.gender) && Objects.equals(enabled, personVO.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, firstName, lastName, address, gender, enabled);
	}

}