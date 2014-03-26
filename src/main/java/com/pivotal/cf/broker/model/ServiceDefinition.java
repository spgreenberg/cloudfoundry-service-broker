package com.pivotal.cf.broker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * A service offered by this broker.
 * 
 * @author sgreenberg@gopivotal.com
 *
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
public class ServiceDefinition {

	@NotEmpty
	@JsonSerialize
	@JsonProperty("id")
	private String id;
	
	@NotEmpty
	@JsonSerialize
	@JsonProperty("name")
	private String name;
	
	@NotEmpty
	@JsonSerialize
	@JsonProperty("description")
	private String description;
	
	@NotEmpty
	@JsonSerialize
	@JsonProperty("bindable")
	private boolean bindable;
	
	@NotEmpty
	@JsonSerialize
	@JsonProperty("plans")
	private List<Plan> plans = new ArrayList<Plan>();
	
	@JsonSerialize
	@JsonProperty("tags")
	private List<String> tags = new ArrayList<String>();
	
	@JsonSerialize
	@JsonProperty("metadata")
	private Map<String,Object> metadata = new HashMap<String,Object>();
	
	@JsonSerialize
	@JsonProperty("requires")
	private List<String> requires = new ArrayList<String>();
	
	public ServiceDefinition(String id, String name, String description, boolean bindable, List<Plan> plans) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.bindable = bindable;
		this.setPlans(plans);
	}

	public ServiceDefinition(String id, String name, String description, boolean bindable, List<Plan> plans,
			Map<String,Object> metadata) {
		this(id, name, description, bindable, plans);
		setTags(tags);
		setMetadata(metadata);
	}
	public ServiceDefinition(String id, String name, String description, boolean bindable, List<Plan> plans,
			List<String> tags, Map<String,Object> metadata, List<String> requires) {
		this(id, name, description, bindable, plans, metadata);
		setTags(tags);
		setRequires(requires);
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isBindable() {
		return bindable;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	private void setPlans(List<Plan> plans) {
		if ( plans == null ) {
			// ensure serialization as an empty array and not null
			this.plans = new ArrayList<Plan>();
		} else {
			this.plans = plans;
		}
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		if (tags == null) {
			this.tags = new ArrayList<String>();
		} else {
			this.tags = tags;
		}
	}

	public List<String> getRequires() {
		return requires;
	}

	public void setRequires(List<String> requires) {
		if (requires == null) {
			this.requires = new ArrayList<String>();
		} else {
			this.requires = requires;
		}
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		if (metadata == null) {
			this.metadata = new HashMap<String,Object>();
		} else {
			this.metadata = metadata;
		}
	}

}
