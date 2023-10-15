package ru.filippov.SpringBootLab1.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HelloController {

    private static List<String> arrayList = new ArrayList<>();
    private static Map<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

    @Controller
    public class MyController {

        @GetMapping("/update-array/{s}")
        @ResponseBody
        public String updateArrayList(@PathVariable("s") String s) {
            arrayList.add(s);
            return "Value '" + s + "' added to ArrayList";
        }

        @GetMapping("/show-array")
        @ResponseBody
        public List<String> showArrayList() {
            return arrayList;
        }

        @GetMapping("/update-map/{key}/{value}")
        @ResponseBody
        public String updateHashMap(@PathVariable("key") String key, @PathVariable("value") String value) {
            hashMap.put(key, value);
            return "Value '" + value + "' added to HashMap";
        }

        @GetMapping("/show-map")
        @ResponseBody
        public Map<String, String> showHashMap() {
            return hashMap;
        }

        @GetMapping("/show-all-length")
        @ResponseBody
        public String showAllLength() {
            int arrayListSize = arrayList.size();
            int hashMapSize = hashMap.size();

            return "ArrayList size: " + arrayListSize + ". HashMap size: " + hashMapSize + ".";
        }
    }
}
