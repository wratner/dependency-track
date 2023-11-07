/*
 * This file is part of Dependency-Track.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package org.dependencytrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.dependencytrack.persistence.converter.OrganizationalContactsJsonConverter;
import org.dependencytrack.persistence.converter.OrganizationalEntityJsonConverter;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Convert;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;
import java.util.List;

/**
 * @since 4.10.0
 */
@PersistenceCapable(table = "PROJECT_METADATA")
@JsonInclude(Include.NON_NULL)
public class ProjectMetadata {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
    @JsonIgnore
    private long id;

    @Persistent
    @Unique(name = "PROJECT_METADATA_PROJECT_ID_IDX")
    @Column(name = "PROJECT_ID", allowsNull = "false")
    @JsonIgnore
    private Project project;

    @Persistent
    @Convert(OrganizationalEntityJsonConverter.class)
    @Column(name = "MANUFACTURER", jdbcType = "CLOB", allowsNull = "true")
    private OrganizationalEntity manufacturer;

    @Persistent
    @Convert(OrganizationalEntityJsonConverter.class)
    @Column(name = "SUPPLIER", jdbcType = "CLOB", allowsNull = "true")
    private OrganizationalEntity supplier;

    @Persistent
    @Convert(OrganizationalContactsJsonConverter.class)
    @Column(name = "AUTHORS", jdbcType = "CLOB", allowsNull = "true")
    private List<OrganizationalContact> authors;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    public OrganizationalEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(final OrganizationalEntity manufacturer) {
        this.manufacturer = manufacturer;
    }

    public OrganizationalEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(final OrganizationalEntity supplier) {
        this.supplier = supplier;
    }

    public List<OrganizationalContact> getAuthors() {
        return authors;
    }

    public void setAuthors(final List<OrganizationalContact> authors) {
        this.authors = authors;
    }

}
