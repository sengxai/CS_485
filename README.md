# three-level-authentication

This was a capstone project built by four members in the course CS485 (Software Engineering II).
Contributing members: Seng Xai Yang, Richard Yang, Patrick Yoong, Marcelo Telleria.
This was developed in the language Java and the database was in Oracle SQL.
This is a three level authentication system as the user progresses onto each level the difficulty increases.
First level is a username/text password.
Second level is a random graphical password.
Third level is a random RGB sequence password.

We do have a SRS document, but due to this being a capstone assignment it will not be uploaded.

If requested for the SRS document I'll be able to send it via email.

<h2>Features:</h2>
  <h3>Hints to help the user</h3>
  <h3>Timed banning for multiple failed attempts</h3>
  <h3>Forgot username/password and will be sent to the users email (For the first level)</h3>
  
  ![image](https://user-images.githubusercontent.com/60667952/119179690-dafcd300-ba34-11eb-80d3-0337361b6dc9.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179714-e3550e00-ba34-11eb-82dd-2887abd84ffa.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179743-ecde7600-ba34-11eb-89ab-e9f03413dbde.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179769-f36ced80-ba34-11eb-8514-885c455ef320.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179778-f7007480-ba34-11eb-93cf-267d898f8ac5.png)

  <h3>Forgot password for both second and third level ( Will be sent to the users email)</h3>
  
  ![image](https://user-images.githubusercontent.com/60667952/119179827-07185400-ba35-11eb-91f9-1ccad8566892.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179844-0b447180-ba35-11eb-9860-692e134946f8.png)
  
  ![image](https://user-images.githubusercontent.com/60667952/119179941-30d17b00-ba35-11eb-9c19-c595c4f9d342.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179996-43e44b00-ba35-11eb-9ff6-110ffedb2479.png)

  

<h2>Registration route:</h2>
  <h3>Sign up form</h3>
  Signs up with their first/last name, email, username, and a picture to identify who they are.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179188-41352600-ba34-11eb-94d2-bf5a82e43469.png)

  <h3>Creation of text password</h3>
  Then they create a text password with a policy of 8 characters at the minimum, 1 uppercase letter, 1 number, and 1 special character.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179284-5b6f0400-ba34-11eb-9b2b-5e64ccbaa7fc.png)

  <h3>Creation of graphical password</h3>
  For the second level is the graphical password where the user must select a category and choose a minimum of 3 images.
  
  ![image](https://user-images.githubusercontent.com/60667952/119180412-e43a6f80-ba35-11eb-9176-8e83f6d1a56e.png)
  ![image](https://user-images.githubusercontent.com/60667952/119181307-01bc0900-ba37-11eb-9f50-78b3b879dee1.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179335-69248980-ba34-11eb-84d2-02bc3ccc9a25.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179363-704b9780-ba34-11eb-9ff1-4ec6381c5c56.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179374-73df1e80-ba34-11eb-8fa9-2c5b80a2a4a9.png)

  <h3>Creation of RGB password sequence</h3>
  Then for the third level has numbers assigned to each color from 1-9. The password policy for this level is that a minimum of 4 numbers/buttons must be clicked, 3 of the buttons clicked must be in a consecutive sequence (i.e 123, 789, 234), and ONLY a maximum of 3 buttons clicked in a consecutive sequence (i.e 1234 = Invalid).
  
  ![image](https://user-images.githubusercontent.com/60667952/119179458-89ecdf00-ba34-11eb-93af-d2d1fa73e0fb.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179462-8ce7cf80-ba34-11eb-96f1-9ab8264df966.png)
  
  <h3>Confirmationing RGB Password Sequence</h3>
  Then a confirmation page to confirm the third level sequence.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179486-92ddb080-ba34-11eb-9a72-b43a6f766d8e.png)
  
   <h3>Confirmation Page</h3>
  A confirmation if the account has been created or not.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179563-b0127f00-ba34-11eb-8084-5f77314129fc.png)

 <h2>Login route</h2>
  <h3>Username/Text Password First Level Login</h3>
  First level is a username and a text password login which will display an image that the user used to sign up with.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179639-c91b3000-ba34-11eb-9928-38ccafb982df.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179666-d1736b00-ba34-11eb-98f4-adaac68fe6b4.png)

  <h3>Graphical Second Level Login</h3>
  Second level is the graphical password that will be randomized on a 3x3 grid and out of those 9 images will be random images along with the images that the user signed up with.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179871-13041600-ba35-11eb-9a25-0ec8cc25bebb.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179884-18616080-ba35-11eb-9768-dfdeff9b37fd.png)
  
  <h3>RGB Randomized Third Level Login</h3>
  Third level is the RGB random password. The colors will be randomized on the grid and the user must select the correct color sequence as when they signed up with.
  
  ![image](https://user-images.githubusercontent.com/60667952/119179914-244d2280-ba35-11eb-9157-de02a331d79d.png)
  ![image](https://user-images.githubusercontent.com/60667952/119179928-2c0cc700-ba35-11eb-8e24-abe558c92d62.png)

