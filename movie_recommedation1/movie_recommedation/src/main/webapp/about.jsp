<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Movie Booking System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: black;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 50px;
            background: #333;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            z-index: 10;
        }
        .navbar .logo {
            font-size: 24px;
            font-weight: bold;
            color: #FFD700;
            text-decoration: none;
        }
        .navbar .menu a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-size: 18px;
            transition: 0.3s;
        }
        .navbar .menu a:hover {
            color: #FFD700;
        }
        .container {
            margin-top: 100px;
            padding: 20px;
        }
        h2 {
            color: #333;
            font-size: 32px;
        }
        p {
            font-size: 18px;
            color: #555;
            max-width: 800px;
            margin: 10px auto;
            line-height: 1.6;
        }
        .about-box {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.2);
            max-width: 800px;
            margin: auto;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="#" class="logo">🎬 MovieBooking</a>
        <div class="menu">
            <a href="index.html">Home</a>
            <a href="search.html">Search Movies</a>
            <a href="about.jsp">About</a>
            <a href="login.jsp">Login/Logout</a>
        </div>
    </div>

    <div class="container">
        <div class="about-box">
            <h2>About Movie Booking System</h2>
            <p>
                Welcome to the **Movie Booking System**, your go-to platform for booking movie tickets effortlessly.
                Whether you’re looking for the latest blockbusters or timeless classics, we make it easy to find and book your favorite movies.
            </p>
            <p>
                Our goal is to enhance your movie-going experience with a **fast, user-friendly, and reliable booking system**.
                Enjoy a hassle-free way to secure your seats, view show timings, and explore movies by genre and price.
            </p>
            <p>
                We believe in providing the **best entertainment experience** with a smooth, seamless process for all movie lovers!
            </p>
        </div>
    </div>

</body>
</html>
