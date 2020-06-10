# uwg-project2-final-project
<h1>RPG Story Mapper</h1>
<h2>Project Overview</h2>
<p>Our Story Mapper application is an attempt to bridge the gap between content creators and content storage.</p>

<p>The collaborators on this project agree a technical skill gap exists for many creative story tellers. In the world of RPG games this gap is all to often present. Many times, those most equipped to create compelling stories, or RPG quests, are the least equipped to manage the very content they have created. We believe steps to soften the skills neccessary to create stories will serve as a benefit to the entire RPG industry.</p>

<p>Through this project we seek to create a GUI application, focused on ease of use, that will allow even the least technically skilled to develop content through a guided process. Saved to a DB, stories can be created and shared simply throughout an organzation. Creators can focus on what they do best and stories will be all the better for it. </p>

<p>We expect to have an intial version completed over the course of the 2020 summer semester. Upon completion, this software will be useful in practice and as an example of our technical skills. We believe this application will be well recieved. We hope you enjoy it.</p>

<h2>Project Vision Statement and Elevator Pitch</h2>
<p>To help interactive content creators communitcate compelling stories to database operators through guided process.</p>
<p><a title="RPG Story Mapper Elevator Pitch on YouTube" href="https://youtu.be/LpU7UVJjGFY">Elevator Pitch</a> on YouTube.</p>
<h2>Iteration 1</h2>

<h3>Goals</h3>
<ul>
  <li>To create a solid understanding visually and logically of the application’s expectations and requirements.</li>
  <li>To create the application’s database.</li>
  <li>To begin implementation of the GUI, starting with the user login.</li>
</ul>

<h3>User Stories</h3>

<h4>Design the initial UI</h4>
<p>As a CS6290 team member, before development begins, I want to understand the look and feel of the application UI, so I can make better programming decisions once we go to implement.<br>
  <strong>Task Acceptance Criteria:</strong><br>
Visual representation of the UI as wireframe diagrams
Call out the controls being utilized</p>
<hr>

<h4>Design the application DB</h4>
<p>As a CS6290 team member, I want to understand the underlying data model of the Quest Manager application, so I can build the proper models in the Quest Manager application.<br>
  <strong>Task Acceptance Criteria:</strong><br>
Provide an EERD or an ERD
Create the DB in MS SQL Server</p>
<hr>

<h4>User login</h4>
<p>As a user, I want to be able to login to the Quest Manager application with my username and password through the login UI.<br>
  <strong>Requirements Covered:</strong><br>
User must authenticate themselves before accessing the system. The passwords must be stored as encrypted passwords. There is no requirement on what encryption algorithm to use.<br>
  <strong>Task Acceptance Criteria:</strong><br>
Create Login UI from UI wireframe
When either the password or username is incorrect, the user is notified that their login attempt failed.</p>
<hr>

<p>As a user, I want to be able to create a new game story.</p>
<hr>
<p>As a user, I want to load an existing game story.</p>
<hr>
<p>As a user, I want to be able to create both playable and non-playable characters.</p>
<hr>
<p>As a user, I want to be able to create items.</p>
<hr>
<p><strong>Issues: </strong><a target="blank" title="Track issues at Trello" href="https://trello.com/b/gGr4IUbZ/cs6920-team-project">Issue Tracking on Trello</a></p>
<h3>Task Assignments</h3>
<ul>
  <li>DB Design ERD for Characters, Players, Admins, and Items - Hodge</li>
  <li>DB MySQL implementation - Hodge</li>
  <li>Characters DAL & Controller - Scott</li>
  <li>Players DAL & Controller - Scott</li>
  <li>Admins DAL & Controller - Scott</li>
  <li>Items DAL & Controller - Scott</li>
  <li>Characters Model - A.Palmer</li>
  <li>Players Model - A.Palmer</li>
  <li>Admins Model - A.Palmer</li>
  <li>Items Model - A.Palmer</li>
  <li>UI Wireframe for Iteration 1 GUI elements (and preparing for Iteration 2 elements) - Hodge</li>
  <li>GUI - login - Hodge</li>
  <li>GUI - Management Dashboard - Scott</li>
  <li>GUI - Category Management (The Iteration 1 categories are largely the same layout) - Palmer</li>
</ul>
