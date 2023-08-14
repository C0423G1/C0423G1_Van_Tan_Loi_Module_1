<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJAX Demo</title>
</head>
<body>
<h1>Random Number Generator</h1>
<p>Click the button to generate a random number:</p>
<button id="generateBtn">Generate</button>
<p id="result">Result will be shown here.</p>

<script>
    document.getElementById("generateBtn").addEventListener("click", function() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "RandomNumberServlet", true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                document.getElementById("result").innerHTML = "Random number: " + xhr.responseText;
            } else {
                console.error("Request failed. Status:", xhr.status);
            }
        };
        xhr.send();
    });
</script>
</body>
</html>
