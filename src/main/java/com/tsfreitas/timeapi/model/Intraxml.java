package com.tsfreitas.timeapi.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by tsfreitas on 22/04/16.
 */
@Root(name = "bp", strict = false)
public class Intraxml {

	@Path("prd")
	@Attribute(name = "id")
	private String id;

	@Path("prd")
	@ElementList(entry="prc", inline=true)
	private List<Price> prices;

}

@Root
class Price {

	@Attribute(name = "tprc")
	private String type;

	@Attribute(name = "vlr")
	private Double value;
}
