package org.com.mba;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class YAMLTest {


    public static void main(String... args) {


        Yaml yaml = new Yaml();
        InputStream inputStream = YAMLTest.class.getClassLoader().getResourceAsStream("teste.yml");
        Map<String, Object> obj = yaml.load(inputStream);


        Map<String, Object> mapAdjustmentCore = (Map<String,Object>) obj.get("adjustment-core");
        Map<String, Map<String,String>> mapResendConditions = (Map<String,Map<String,String>>) mapAdjustmentCore.get("resend-conditions");
        Collection<Map<String,Collection>>  lstStatus =  (Collection<Map<String,Collection>> ) mapResendConditions.get("status");

        final Map<String,Collection<String>> mapStatusReasons = new HashMap<>();

        lstStatus.forEach(mapStatus -> {

            mapStatus.keySet().forEach(status -> {
                 mapStatusReasons.put(status,(Collection<String>) ((Map)mapStatus.get(status)).get("reasons"));
            });

        });


        System.out.println(mapStatusReasons);

    }

}
