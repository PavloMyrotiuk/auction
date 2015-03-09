<center><h1>Auction application</h1></center>

<i>Description:</i>
<p>This is auction platform, where people can sell and buy different things.
Only authorized users can sell and buy things. All users can look(search) things(products/lots).
Everyone can sign up buy providing login(email), password and name.
To log in user should insert email and password in the appropriate form.
After log in, user has more capabilities, such as adding products and betting.</p>
<p>This is distributed application that consist of: middleware, engine, UI client.
UI client written on AngularJS and communicates with middleware by means of REST and WebSocket.
"Engine" is part of application that is responsible for business logic.
"Engine" communicates with middleware by means of JMS.
When user adds a new product, the product is being saved to the DB and lightweight message is being sent to JMS queue.
"Engine" listen to the appropriate queue and apply necessary logic for created product.
When time for betting has run out, "Engine" changes product status so users can not bet any more.
</p>

<i>UML:</i>
<ul>
<li><a href="https://creately.com/diagram/i56j9hdg/G8YmoeC0Ekn4pkSNJU6YStySXcU%3D">High level component diagram</a></li>
<li><a href="https://creately.com/diagram/i591up0v1/wfZjFNHkbfrvGcz8gR4fpKBeEqI%3D">Packages dependencies diagram</a></li>
</ul>


<i>Technologies:</i>
<ul>
<li>Build tool: gradle</li>
<li>Servlet-api: 3.1</li>
<li>WebServer: Apache Tomcat-8.0.17</li>
<li>JMS broker: Apache ActiveMQ-5.9.1</li>
<li>Inversion of control:  Spring Framework </li>
<li>Spring REST, WebSocket</li>
<li>Database: MongoDB</li>
<li>UI: AngularJS</li>
<li>VCS: git</li>
</ul>