<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Best fit
</h1>
<br/>
<a href="hello-servlet">Start BestFit</a>
<br><br>
<br><hr>
<h2>Second Chance</h2>
<form method="POST" action="hello-servlet">
    <input type="text" name="string" placeholder="string of numbers" >
    <input type="text" name="frame" placeholder="frame" id="frame">
    <input type="submit" value="Calculate">
</form>
</body>
</html>