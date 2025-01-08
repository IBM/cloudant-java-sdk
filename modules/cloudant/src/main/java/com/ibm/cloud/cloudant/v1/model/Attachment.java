/*
 * (C) Copyright IBM Corp. 2025.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.cloudant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schema for an attachment.
 */
public class Attachment extends GenericModel {

  @SerializedName("content_type")
  protected String contentType;
  protected byte[] data;
  protected String digest;
  @SerializedName("encoded_length")
  protected Long encodedLength;
  protected String encoding;
  protected Boolean follows;
  protected Long length;
  protected Long revpos;
  protected Boolean stub;

  /**
   * Builder.
   */
  public static class Builder {
    private String contentType;
    private byte[] data;
    private String digest;
    private Long encodedLength;
    private String encoding;
    private Boolean follows;
    private Long length;
    private Long revpos;
    private Boolean stub;

    /**
     * Instantiates a new Builder from an existing Attachment instance.
     *
     * @param attachment the instance to initialize the Builder with
     */
    private Builder(Attachment attachment) {
      this.contentType = attachment.contentType;
      this.data = attachment.data;
      this.digest = attachment.digest;
      this.encodedLength = attachment.encodedLength;
      this.encoding = attachment.encoding;
      this.follows = attachment.follows;
      this.length = attachment.length;
      this.revpos = attachment.revpos;
      this.stub = attachment.stub;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Attachment.
     *
     * @return the new Attachment instance
     */
    public Attachment build() {
      return new Attachment(this);
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the Attachment builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the data.
     *
     * @param data the data
     * @return the Attachment builder
     */
    public Builder data(byte[] data) {
      this.data = data;
      return this;
    }

    /**
     * Set the digest.
     *
     * @param digest the digest
     * @return the Attachment builder
     */
    public Builder digest(String digest) {
      this.digest = digest;
      return this;
    }

    /**
     * Set the encodedLength.
     *
     * @param encodedLength the encodedLength
     * @return the Attachment builder
     */
    public Builder encodedLength(long encodedLength) {
      this.encodedLength = encodedLength;
      return this;
    }

    /**
     * Set the encoding.
     *
     * @param encoding the encoding
     * @return the Attachment builder
     */
    public Builder encoding(String encoding) {
      this.encoding = encoding;
      return this;
    }

    /**
     * Set the follows.
     *
     * @param follows the follows
     * @return the Attachment builder
     */
    public Builder follows(Boolean follows) {
      this.follows = follows;
      return this;
    }

    /**
     * Set the length.
     *
     * @param length the length
     * @return the Attachment builder
     */
    public Builder length(long length) {
      this.length = length;
      return this;
    }

    /**
     * Set the revpos.
     *
     * @param revpos the revpos
     * @return the Attachment builder
     */
    public Builder revpos(long revpos) {
      this.revpos = revpos;
      return this;
    }

    /**
     * Set the stub.
     *
     * @param stub the stub
     * @return the Attachment builder
     */
    public Builder stub(Boolean stub) {
      this.stub = stub;
      return this;
    }
  }

  protected Attachment() { }

  protected Attachment(Builder builder) {
    contentType = builder.contentType;
    data = builder.data;
    digest = builder.digest;
    encodedLength = builder.encodedLength;
    encoding = builder.encoding;
    follows = builder.follows;
    length = builder.length;
    revpos = builder.revpos;
    stub = builder.stub;
  }

  /**
   * New builder.
   *
   * @return a Attachment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the contentType.
   *
   * Attachment MIME type.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the data.
   *
   * Base64-encoded content. Available if attachment content is requested by using the query parameters
   * `attachments=true` or `atts_since`. Note that when used with a view or changes feed `include_docs` must also be
   * `true`.
   *
   * @return the data
   */
  public byte[] data() {
    return data;
  }

  /**
   * Gets the digest.
   *
   * Content hash digest. It starts with prefix which announce hash type (e.g. `md5-`) and continues with Base64-encoded
   * hash digest.
   *
   * @return the digest
   */
  public String digest() {
    return digest;
  }

  /**
   * Gets the encodedLength.
   *
   * Compressed attachment size in bytes. Available if content_type was in list of compressible types when the
   * attachment was added and the query parameter `att_encoding_info` is `true`. Note that when used with a view or
   * changes feed `include_docs` must also be `true`.
   *
   * @return the encodedLength
   */
  public Long encodedLength() {
    return encodedLength;
  }

  /**
   * Gets the encoding.
   *
   * Compression codec. Available if content_type was in list of compressible types when the attachment was added and
   * the and the query parameter `att_encoding_info` is `true`. Note that when used with a view or changes feed
   * `include_docs` must also be `true`.
   *
   * @return the encoding
   */
  public String encoding() {
    return encoding;
  }

  /**
   * Gets the follows.
   *
   * True if the attachment follows in a multipart request or response.
   *
   * @return the follows
   */
  public Boolean follows() {
    return follows;
  }

  /**
   * Gets the length.
   *
   * Real attachment size in bytes. Not available if inline attachment content requested.
   *
   * @return the length
   */
  public Long length() {
    return length;
  }

  /**
   * Gets the revpos.
   *
   * Revision number when attachment was added.
   *
   * @return the revpos
   */
  public Long revpos() {
    return revpos;
  }

  /**
   * Gets the stub.
   *
   * Has `true` value if object contains stub info and no content. Otherwise omitted in response.
   *
   * @return the stub
   */
  public Boolean stub() {
    return stub;
  }
}

