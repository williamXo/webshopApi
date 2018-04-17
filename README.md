# api

Api ip address
---
http://167.99.215.253:8080/api


Account information
---
**Normal user**
Username: user
Password: user

**Admin user**
Username: admin
Password: admin

#/user 
	[GET]	
	 @RolesAllowed("admin")
	/{username}
	returns object of user by name
	
	[PUT]	
	/update		(User user)
	updates the user
	
	[GET]	
	/login		(Authorization)
	returns valid user
	
	[POST]
    /register   (User user)
    creates a new user
    
    [DELETE]
     @RolesAllowed("admin")
     /delete/{id}"
     deletes account by id
	
#/products 
		
	[GET]	
	/
	returns all products
	
	[GET]	
	/{id}
	returns product by id}
	
	[PUT]	
	 @RolesAllowed("admin")
	/update (Product product)
	Updates the product
	
	[POST]
	 @RolesAllowed("admin")
	/add		(Product product)
	adds a product to the database
	
    [DELETE]
    @RolesAllowed("admin")
    /{id}
    Deletes the product by id

#/order 
    		
    	[GET]	
    	@RolesAllowed("admin")
    	/
    	returns all orders
    	
    	[GET]	
    	/{id}
    	returns order by id
    	
    	[GET]	
    	@RolesAllowed("admin")
    	/user/{id}
    	returns order by id
    	
    	[GET]	
    	/user		(Authorization)
    	returns order by by user id
    	
    	[POST]
    	/		(Order order, Authorization)
    	adds a order to the database
    	
    	