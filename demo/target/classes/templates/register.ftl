<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="bg">
            <div class="login-space">
                <p class="heading">${register}</p>
                <form class="login" action="/register" method="post">
                    <input type="text" name="name" class="input-field" placeholder="Enter FullName" required>
                    <input type="text" name="username" class="input-field" placeholder="Create Username" required>
                    <input type="text" name="mobile" class="input-field" placeholder="Mobile no." required>
<input type="text" class="input-field" name="mailid" placeholder="Enter your mailid" required>
                    <input type="password" name="password" class="input-field" id="password" placeholder="Create Password" required>

                    <button type="submit" class="submit-btn">Register</button>
                </form>
                <p>Don't have an account? <a href="/">login</a></p>
            </div>
        </div>
</body>
</html>
