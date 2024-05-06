<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="bg">
        <div class="login-space">
            <p class="heading">${login}</p>
            <form class="login" action="/" method="post">
                <input type="text" class="input-field" name="username" placeholder="Username" required>

                <input type="password" class="input-field" name="password" id="password" placeholder="Password" required>

                <button type="submit" class="submit-btn">LogIn</button>
                <p style="color: red">${error!""}</p>
            </form>
            <a href="#" class="forgot-pass">Forgot password?</a>
            <p class="reg-nav">Don't have an account? <a class="reg-link" href="/register">register</a></p>
        </div>
    </div>
</body>
</html>
