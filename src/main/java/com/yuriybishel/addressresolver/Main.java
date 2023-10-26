package com.yuriybishel.addressresolver;

import com.yuriybishel.addressresolver.service.AddressService;
import com.yuriybishel.addressresolver.util.XmlUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {

            ClassLoader classLoader = Main.class.getClassLoader();
            String pathToAddresses = Objects.requireNonNull(classLoader.getResource("AS_ADDR_OBJ.XML")).getPath();
            String pathToHierarchies = Objects.requireNonNull(classLoader.getResource("AS_ADM_HIERARCHY.XML")).getPath();

            var addresses = XmlUtils.readAddressesFromFile(pathToAddresses);
            var hierarchies = XmlUtils.readHierarchiesFromFile(pathToHierarchies);

            AddressService addressService = new AddressService(addresses, hierarchies);

            // Задаем дату и список идентификаторов
            LocalDate date = LocalDate.parse("2010-01-01");
            List<Integer> objectIds = List.of(1422396, 1450759, 1449192, 1451562);

            // Вызываем метод для вывода описания адресов
            addressService.describeAddresses(date, objectIds);

            //Вызываем метод для полных адресов полные (строку с цепочкой адресов по иерархии)
            addressService.printActualFullAddresses();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

