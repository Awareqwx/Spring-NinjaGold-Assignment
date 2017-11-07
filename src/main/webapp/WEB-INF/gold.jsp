<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>Ninja Gold</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h4>Your Gold: ${gold}</h4>
        <div class="goldbox">
            <h3>Farm</h3>
            <p>(Earns 10-20 gold)</p>
            <form action="/process" method="post">
                <input type="hidden" name="gold" value="10/20">
                <input type="hidden" name="location" value="Farm">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="goldbox">
            <h3>Cave</h3>
            <p>(Earns 5-10 gold)</p>
            <form action="/process" method="post">
                <input type="hidden" name="gold" value="5/10">
                <input type="hidden" name="location" value="Cave">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="goldbox">
            <h3>House</h3>
            <p>(Earns 2-5 gold)</p>
            <form action="/process" method="post">
                <input type="hidden" name="gold" value="2/10">
                <input type="hidden" name="location" value="House">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="goldbox">
            <h3>Casino</h3>
            <p>(Earns/takes 0-50 gold)</p>
            <form action="/process" method="post">
                <input type="hidden" name="gold" value="-50/50">
                <input type="hidden" name="location" value="Casino">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <p>Activities:</p>
        <div id="activities">
            ${acts}
        </div>
        <script>
            var element = document.getElementById("activities");
            element.scrollTop = element.scrollHeight;
        </script>
    </body>
</html>