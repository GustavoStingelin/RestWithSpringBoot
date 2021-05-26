package br.com.stingelin.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class UploadFileResponseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String downloadUri;
    private String type;
    private Long size;

    public UploadFileResponseVO() {
    }

    public UploadFileResponseVO(String name, String downloadUri, String type, Long size) {
        this.name = name;
        this.downloadUri = downloadUri;
        this.type = type;
        this.size = size;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadUri() {
        return this.downloadUri;
    }

    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UploadFileResponseVO)) {
            return false;
        }
        UploadFileResponseVO uploadFileResponseVO = (UploadFileResponseVO) o;
        return Objects.equals(name, uploadFileResponseVO.name)
                && Objects.equals(downloadUri, uploadFileResponseVO.downloadUri)
                && Objects.equals(type, uploadFileResponseVO.type) && Objects.equals(size, uploadFileResponseVO.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, downloadUri, type, size);
    }

}
