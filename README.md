# Todo Project
You are able to:
<ol>
<li>Sign in with google</li>
<li>List all Todo items</li>
<li>Add a Todo item</li>
<li>Delete a Todo item</li>
<li>Mark a Todo item as completed</li>
</ol>

## Prerequisite
You need to have:
<br>
Java 18
<br>
Maven 3.8.5
<br>
IntelliJ IDEA or other code editor
<br>
Postman (https://www.postman.com/downloads/)

## Running the Todo Project app
<ol>
<li>Download and unzip the todoproject</li>
<li>Open the project folder with IntelliJ</li>
<li>Run the <b><i>TodoprojectApplication.java</i></b></li>
<li>Go to <b><i>http://localhost:8080/</i></b></li>
<kbd><img src="https://user-images.githubusercontent.com/72722068/183244773-d163e821-f5cf-4f76-8153-a291d1a6ae78.png"></kbd>
</ol>

## Testing the Todo Project app
I'm using Postman application to use and test the todoproject for adding, updating and deleting todo item.
<ol>
<li>Sign in with google</li>
  <ul>
  <li>Go to <b><i>http://localhost:8080/signin</i></b></li>
  <li>If you haven't signin yet, it will redirect you to google sign-in</li>
  </ul>
  <kbd><img src="https://user-images.githubusercontent.com/72722068/183245134-c9c2e18b-43f5-4d06-b913-a942fc047b43.png" width="600" height="400"></kbd>
<li>Once you have signin, go to <b><i>http://localhost:8080/check</i></b></li>
  <ul>
  <li>You are able to check your user id for purposes of adding, updating and deleting the todo items</li>
  </ul>
  <kbd><img src="https://user-images.githubusercontent.com/72722068/183245446-dc84593d-6320-4688-adc6-7cb172288e80.png"></kbd>
<li>To list all the todo items, go to <b><i>http://localhost:8080/user/{userid}/list</i></b></li>
  <ul>
  <li>Replace {userid} with the user id you had check previously</li>
  </ul>
  <kbd><img src="https://user-images.githubusercontent.com/72722068/183245578-099810ef-0a82-421a-825b-c5fa320b3b0a.png"></kbd>
<li>To add a new todo item, open Postman and setup like below:
  <ul>
  <li>URL used is <b><i>http://localhost:8080/user/{userid}/add</i></b></li>
  <li>Replace {userid} with the user id you had check previously</li>
  <li>Click Send</li>
  <li>Go to <b><i>http://localhost:8080/user/{userid}/list</i></b> and see the newly added item in the list</li>
  </ul>
  <kbd><img src="https://user-images.githubusercontent.com/72722068/183245747-e5050dae-b8bc-42c0-a00e-74814fb7f488.png"></kbd>
<li>To update a todo item, open Postman and setup like below:
  <ul>
  <li>URL used is <b><i>http://localhost:8080/user/{userid}/update/{todoid}</i></b></li>
  <li>Replace {userid} with the user id you had check previously</li>
  <li>Replace {todoid} with the todo id which can be refer in the list</li>
  <li>Click Send</li>
  <li>Go to <b><i>http://localhost:8080/user/{userid}/list</i></b> and see the updated item in the list</li>
  </ul>
  <kbd><img src="https://user-images.githubusercontent.com/72722068/183246010-6de861bc-e4a5-4751-963f-a420e6a8125f.png"></kbd>
<li>To delete a todo item, open Postman and setup like below:
  <ul>
  <li>URL used is <b><i>http://localhost:8080/user/{userid}/delete/{todoid}</i></b></li>
  <li>Replace {userid} with the user id you had check previously</li>
  <li>Replace {todoid} with the todo id which can be refer in the list</li>
  <li>Click Send</li>
  <li>Go to <b><i>http://localhost:8080/user/{userid}/list</i></b> and see the latest list</li>
  </ul>
  <kbd><img src="https://user-images.githubusercontent.com/72722068/183246089-eb6a556d-56a8-45d2-9be1-f7fa0a9448bd.png"></kbd>
</ol>
