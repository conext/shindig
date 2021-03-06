/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shindig.social.opensocial.jpa;

import static javax.persistence.GenerationType.IDENTITY;

import org.apache.shindig.social.opensocial.jpa.api.DbObject;
import org.apache.shindig.social.opensocial.model.ListField;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import java.util.Map;

/**
 * Stores information about applications
 */
@Entity
@Table(name = "application")
public class ApplicationDb implements DbObject {
  /**
   * The internal object ID used for references to this object. Should be generated by the
   * underlying storage mechanism
   */
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "oid")
  protected long objectId;

  /**
   * An optimistic locking field.
   */
  @Version
  @Column(name = "version")
  protected long version;


  /**
   * The application has properties.
   */
  @OneToMany(targetEntity = ApplicationPropertyDb.class, mappedBy = "application")
  @MapKey(name = "type")
  protected Map<String, ListField> properties;


  /**
   * Each Application has an Id
   */
  @Basic
  @Column(name = "id", length = 255)
  protected String id;


  /**
   * @return the properties
   */
  public Map<String, ListField> getProperties() {
    return properties;
  }


  /**
   * @param properties the properties to set
   */
  public void setProperties(Map<String, ListField> properties) {
    this.properties = properties;
  }


  /**
   * @return the id
   */
  public String getId() {
    return id;
  }


  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }


  /**
   * @return the version
   */
  public long getVersion() {
    return version;
  }


  /**
   * @return the objectId
   */
  public long getObjectId() {
    return objectId;
  }


}
