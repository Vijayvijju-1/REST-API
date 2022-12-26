package demooo.rest;

import java.util.List;

import jakarta.ws.rs.*;

import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;

@Path("books")

public class AlienResource {
	
	AlienRepository db = new AlienRepository();
	
	@GET
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_XML)	
	
	public List<Alien> getAliens() {
		
	
		
		return db.getAliens();
	}
	@GET
	@Path("book/{id}")// finding by id
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_XML)	
	public Alien getAlienBook(@PathParam("id")int id) { // id representation
		
		
		return db.getBookId(id);
	}
	@GET
	@Path("user/{id}")// finding by id
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_XML)	
	public Alien getAlien(@PathParam("id")int id) { // id representation
		
	
		
		return db.getAlien(id);
	}
//	@GET
//	@Path("user/{userid}")// finding by id
////	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	@Produces(MediaType.APPLICATION_XML)	
//	public Alien getUser(@PathParam("userid")int userid) { // id representation
//		
//	System.out.println(db.getUserId(userid)+"getuser");
//		
//		return db.getUserId(userid);
//	}
	
	@POST
	@Path("book")
	//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_XML)
	public Alien createAlien(Alien a1) {
		db.create(a1);
		return a1;
	}
	
	@PUT
	@Path("book")
	//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_XML)
	public Alien updateAlien(Alien a1) {
		
			db.update(a1);
		
		
		return a1;
	}
	@Path("user/{id}")
	@DELETE
	
	public Alien deleteAlien(@PathParam("id")int id) {
		Alien a=db.getAlien(id);
		if(a.getUserId()!=0)
		db.delete(id);
		return a;
	}
	
	@Path("book")
	@PATCH	
	public Alien createPatchAlien(Alien a1) {
		db.update(a1);
		return a1;
	}
	@GET
	@Path("filter")
	public List<Alien> filter(@QueryParam("category") String category,@QueryParam("author") String author) {
		//System.out.println("vachesa");
		List<Alien> filtered=db.filterCategory(category,author);
		//System.out.println("jksgh");
		return filtered;
	}
}
