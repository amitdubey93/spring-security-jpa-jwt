# In this project.

1. We have used spring-security, spring-data-jpa, h2 in-memory database and jwt authentication for validating user from database.

2. Schema is as per JPA entity which is User is this case.

3. Created endpoint "/authenticate" to generate token.

4. Hooking jwtAuthenticationFilter in SecurityChainFilter so it examines the requestHeader for valid jwt for authentication and sets usernamePasswordAuthenticationToken in SecurityContextHolder for others to use.

5. use "/" endpoint to authenticate yourself using jwt.


