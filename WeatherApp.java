package model;



public class Weather {

    private String city;

    private String condition;

    private double temperature;



    public Weather(String city, String condition, double temperature) {

        this.city = city;

        this.condition = condition;

        this.temperature = temperature;

    }



    public String getCity() {

        return city;

    }



    public String getCondition() {

        return condition;

    }



    public double getTemperature() {

        return temperature;

    }



    public void display() {

        System.out.println("Weather Forecast for " + city + ":");

        System.out.println("Condition: " + condition);

        System.out.println("Temperature: " + temperature + " °C");

        System.out.println("----------------------------------");

    }

}

-----------------------------------------------------------


package service;



import model.Weather;



import java.util.HashMap;

import java.util.Map;



public class WeatherService {

    private Map<String, Weather> weatherMap;



    public WeatherService() {

        weatherMap = new HashMap<>();



       

        weatherMap.put("delhi", new Weather("Delhi", "Sunny", 35.0));

        weatherMap.put("mumbai", new Weather("Mumbai", "Cloudy", 30.5));

        weatherMap.put("bangalore", new Weather("Bangalore", "Rainy", 25.8));

        weatherMap.put("chennai", new Weather("Chennai", "Hot", 38.2));

        weatherMap.put("kolkata", new Weather("Kolkata", "Humid", 33.7));

        weatherMap.put("kurnool", new Weather("Kurnool", "Hot", 40.7));

        weatherMap.put("hyderabad", new Weather("Hyderabad", "Cloudy", 29.7));

        

        

    }



    public Weather getWeather(String city) {

        return weatherMap.get(city.toLowerCase());

    }

}

------------------------------------------------------

package app;



import model.Weather;

import service.WeatherService;



import java.util.Scanner;



public class WeatherApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        WeatherService weatherService = new WeatherService();



        System.out.println("Welcome to the Weather Forecast App!");

        System.out.println("Type the city name to get the forecast (e.g., Delhi, Mumbai):");

        System.out.println("Type 'exit' to quit.\n");



        while (true) {

            System.out.print("Enter city name: ");

            String city = scanner.nextLine();



            if (city.equalsIgnoreCase("exit")) {

                System.out.println("Thanks for using the app!");

                break;

            }



            Weather weather = weatherService.getWeather(city);

            if (weather != null) {

                weather.display();

            } else {

                System.out.println("Weather data for '" + city + "' not found.\n");

            }

        }



        scanner.close();

    }

}

