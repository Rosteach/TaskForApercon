<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Second Task</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/secondTask.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/firstTask.css" />
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/secondTask.js"></script>
	<script type="text/javascript" src="resources/js/firstTask.js"></script>
</head>
<body>
	<!-- <button>Show all figures</button><br>
	<p class="showAllTest"></p><br>
	<button>Show figure by id</button>
	<div id="forFigureById">
		<br>
		<input class="showById" type="text" name="shofById" placeholder="input id" required="required"/><button class="apply">Apply</button><br>
		<p class="showByIdTest"></p>
	</div> -->
	<nav class="nav">
        <ul class="sliding-menu">
           <li><a href="/controllers">Home Page</a></li>
			<li class="active"><a href="firstTask">First Task</a></li>
           <li><a href="secondTask">Second Task</a></li>
           <li><a href="contacts">Contacts</a></li>
        </ul>
    </nav>
    <div class="links">
		<a href="figures/listAll" class="link">Show all figures</a>
		<a href="figures/listAllAreas" class="link">Show all areas</a>
	</div>
</body>
</html>