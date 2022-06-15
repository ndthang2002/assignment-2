	.dropbtn {
	
  padding: 16px;
  font-size: 16px;
  border: none;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
 min-width: 150px;
 height: 150px;
  box-shadow: 5px 8px 16px 0px rgba(191, 163, 163, 0.2);
  z-index: 1;
  margin-left: -19px;
  border-radius: 10px;
  
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.menu-desktop ul li a
{

  text-decoration: none;
}
.menu-desktop ul li a:after
{
content: "";
position: absolute;
background-color: #444444;
height: 3px;
left: 0;
bottom:10px;
text-decoration: none;
transition:3s;



}
.menu-desktop ul li a:hover:after{
     width: 100%;
}
.menu-desktop ul li a:hover{
     color: #FFFFFF;
}


/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: rgb(138, 131, 131);}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {display: block;}

/* Change the background color of the dropdown button when the dropdown content is shown */


.nameshop{
	justify-content: center;
	color: white;
}
.nameshop span{
	animation: glow 2s ease-in-out infinite;

}
@keyframes glow{
	0%,100%{
		color: #FFFFFF;
		text-shadow:0 0 20px lime ,0 0 50px lime ,0 0 100px lime;
	}
	10% ,90%{
		color:#888888;
		text-shadow:none;

	}
}
.nameshop span:nth-child(2){
   animation-delay: 0.25s;
}
.nameshop span:nth-child(3){
   animation-delay: 0.5s;
}
.nameshop span:nth-child(4){
   animation-delay: 0.75s;
}
.nameshop span:nth-child(5){
   animation-delay: 1s;
}
.nameshop span:nth-child(6){
   animation-delay: 1.25s;
}
.nameshop span:nth-child(7){
   animation-delay: 1.5s;
}
.nameshop span:nth-child(8){
   animation-delay: 1.75s;
}
.nameshop span:nth-child(9){
   animation-delay: 2s;
}
.nameshop span:nth-child(10){
   animation-delay: 2.25s;

}

.nameshop span:nth-child(11){
   animation-delay: 2.5s;
}