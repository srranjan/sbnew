package com.mypoc.rest;


import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


//@SpringBootApplication
@RestController
//@Controller
//@RequestMapping("/clients")
public class MyRestController {
 
	@Autowired  //Let me keep the @Autowired thing at bay for sometime
	private ClientRepository clientRepository;
    
	/*private final ClientRepository client;

	  public MyRestControllerr(ClientRepository client) {
	    this.client = client;
	  }*/
 
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping("/clients")
    //public Mono<MyClient> createMyClient(
    public Mono<Void> createMyClient(
    		@RequestBody 
    		Publisher<MyClient> clientStream) 
    {
		
		
		return this.clientRepository.saveAll(clientStream).then();  //.save(clientStream).then();
        //return myClient;
    }

	//@RequestMapping(method = RequestMethod.GET)
    @GetMapping("/clients")
    public Flux<MyClient> listMyClients() {
		
		//System.out.println(" In listMyClients: message = "  + message);
        return this.clientRepository.findAll();
    }
	
	
    
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/clients/{id}")
    public Mono <MyClient> getClient(
    		@PathVariable("id") 
    		Long id) 
    		//throws NotFoundException 
    {
    	//System.out.println(" In getClient: message = "  + message);
    	Mono<MyClient> myClient = this.clientRepository.findById(id);
 
        if (myClient == null) {
            //throw new NotFoundException();
        }
        return myClient;
    }
 
    
    //id is in 2 places, probably a code quality issue. The 2 values are assumed same (one in url, the other in payload)
    //@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/clients/{id}")
    public Mono<Void> updateMyClient(
    		@PathVariable("id") 
    		String id, 
    		@RequestBody 
    		Publisher<MyClient> clientStream) 
    		//		throws NotFoundException 
    {
    	System.out.println(" In updateMyClient: id = "  + id);
    	
    	return this.clientRepository.saveAll(clientStream).then(); //What about id validation for duplicates???
    }
 
 
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/clients/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public  Mono<Void>  deleteMyClient(
    		@PathVariable("id") 
    		Long id) 
    	{
    	System.out.println(" In deleteMyClient: id = " + id);
    	
    	
    	//Mono<MyClient> myClient = this.clientRepository.findById(id);
    	
    	//MyClient theClient = myClient.block();
    	
    	//https://github.com/hantsy/spring-reactive-sample/blob/master/boot-data-mongo/src/main/java/com/example/demo/DemoApplication.java
    	
    	
    	
    	//clientRepository.delete(theClient);
    	
    	return this.clientRepository.deleteById(id); 
    	//return clientRepository.deleteById(idStream).then();
    	
    }
    
}
