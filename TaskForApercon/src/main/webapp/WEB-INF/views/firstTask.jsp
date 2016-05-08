<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>First Task</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/firstTask.css" />
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/firstTask.js"></script>
</head>
<body>
	<nav class="nav">
        <ul class="sliding-menu">
           <li><a href="/controllers">Home Page</a></li>
			<li class="active"><a href="firstTask">First Task</a></li>
           <li><a href="secondTask">Second Task</a></li>
           <li><a href="contacts">Contacts</a></li>
        </ul>
    </nav>
	<div id="content">
		<div class="matrix">
			<input id="numOfTestCases" type="text" name="numOfCases" placeholder="number of test cases" required="required"/><p class="checkCaseTest"></p>
			<button class="clearParam">Clear Test Case</button><button class="apply">Apply</button>
		</div>
		<div class="parameters">
			<p>Example:3 3;3 2;......;9 9;</p>
			<input id="parameter" type="text" name="parameter" placeholder="set parameters"/>
		</div>
			<button class="calc">Calculate</button>
		<div class="output"></div>
	</div>
</body>
</html>