package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import entities.Customer;
import model.CustomerDao;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {

	@GET
	public Response getCustomers(){
		List<Customer> list = new ArrayList<Customer>();
		CustomerDao model = new CustomerDao();
		list = model.getAllCustomers();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return Response.ok("Hello World desde el API REST",MediaType.APPLICATION_JSON).entity(json).build();
	}


	@Path("/{id}")
	@GET
	public Response getCustomer(@PathParam("id") String id) {
		CustomerDao model = new CustomerDao();
		Customer cust = model.getCustomer(new Integer(id));
		Gson gson = new Gson();
		String json = gson.toJson(cust);
		System.out.println(json);
		return Response.ok("Hello World desde el API REST",MediaType.APPLICATION_JSON).entity(json).build();
	}

	@Path("/{name}/{lastName}/{email}/{address}")
	@POST
	public Response createCustomer(@PathParam("name") String name,@PathParam("lastName") String lastName,
			@PathParam("email") String email,@PathParam("address") String address) {
		CustomerDao model = new CustomerDao();
		Customer c = new Customer();

		c.setName(name);
		c.setLastName(lastName);
		c.setAddress(address);
		c.setEmail(email);
		Customer creturn = model.create(c);
		Gson gson = new Gson();
		String json = gson.toJson(creturn);
		System.out.println(json);
		return Response.ok("Hello World desde el API REST",MediaType.APPLICATION_JSON).entity(json).build();
	}

	@Path("/{id}/{name}/{lastName}/{email}/{address}")
	@PUT
	public Response updateCustomer(@PathParam("name") String name,@PathParam("lastName") String lastName,
			@PathParam("email") String email,@PathParam("address") String address) {
		CustomerDao model = new CustomerDao();
		Customer c = new Customer();
		c.setName(name);
		c.setLastName(lastName);
		c.setAddress(address);
		c.setEmail(email);
		model.save(c);
		Gson gson = new Gson();
		String json = gson.toJson(c);
		System.out.println(json);
		return Response.ok("Hello World desde el API REST",MediaType.APPLICATION_JSON).entity(json).build();
	}



}

