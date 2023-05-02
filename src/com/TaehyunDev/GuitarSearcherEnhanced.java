package com.TaehyunDev;

import java.util.List;
import java.util.Scanner;

public class GuitarSearcherEnhanced {

    private static Inventory inventory;
    private static GuitarSearcherEnhanced instance;

  /*
    private String[] checkNullList(String[] inputStringList){
        String[] resultList = new String[inputStringList.length+1];
        int count = 0;
        for(String inputString : inputStringList){
            if(inputString.equals("*")){
                resultList[count] = null;
            }else{
                resultList[count] = inputString;
            }
            count ++;
        }
        return resultList;
    }
   */

    private void searchGuitar() {
        GuitarSpec tempGuitar = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n[검색 마법사]\n문자 항목 미기입시는 'n'을 입력하십시오.\n숫자 항목 미기입시는 -1을 입력하십시오.\n\n제조사를 입력하삽시오(Fender, Yamaha, Samsung):");
            String tempBuilder = scanner.nextLine();
            System.out.println("모델명을 입력하십시오:");
            String tempModel = scanner.next();
            System.out.println("종류를 입력하십시오(Acoustic, Electric, Classic):");
            String tempType = scanner.next();
            System.out.print("줄 갯수를 입력하십시오(미 기입시는 -1): ");
            Integer tempStrings = scanner.nextInt();
            System.out.println("뒷면을 입력하십시오(Alder, Base):");
            String tempBack = scanner.next();
            System.out.println("앞면을 입력하십시오(Alder, Base):");
            String tempFront = scanner.next();
            tempGuitar =
                    new GuitarSpec(Builder.valueOf(tempBuilder.toUpperCase()), tempModel,
                            Type.valueOf(tempType.toUpperCase()), tempStrings, Wood.valueOf(tempBack.toUpperCase()), Wood.valueOf(tempFront.toUpperCase()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n입력 에러 입니다.\n\n");
            searchGuitar();
        }

        if(tempGuitar == null){
            System.out.println("중대에러!");
            System.exit(1);
        }

        List<Guitar> matchingGuitars = inventory.search(tempGuitar);

        if (!matchingGuitars.isEmpty()) {
            System.out.println("[검색결과]");
            int tempCount = 0;
            for (Guitar guitar : matchingGuitars) {
                tempCount++;
                GuitarSpec spec = guitar.getSpec();
                System.out.println("[" +tempCount+"] "+ spec.getModel()+"\n"+
                        "제조사: "+spec.getBuilder()+"\n"+
                        "종류: "+spec.getType()+"\n"+
                        "뒷면: "+spec.getBackWood()+"\n"+
                        "윗면: "+spec.getTopWood()+"\n"+
                        "가격: "+guitar.getPrice() + "\n---------------");
            }
            System.out.println("\n총 "+tempCount+"개의 검색 결과가 있습니다.");
        }else{
            System.out.println("검색 결과가 없습니다.");
        }
        searchGuitar();

    }

    private void initInventory() {
        inventory = new Inventory();
        inventory.addGuitar("11277", 3285.33,
                new GuitarSpec(Builder.FENDER, "TH-1", Type.CLASSIC, 6,
                        Wood.ALDER, Wood.BASE));
        inventory.addGuitar("V95693", 1567.9,
                new GuitarSpec(Builder.FENDER, "TH-2", Type.ELECTRIC, 8,
                        Wood.ALDER, Wood.ALDER));
        inventory.addGuitar("V9512", 1782,
                new GuitarSpec(Builder.YAMAHA, "TH-3", Type.ELECTRIC, 6,
                        Wood.ALDER, Wood.ALDER));
        inventory.addGuitar("122784", 8982.57,
                new GuitarSpec(Builder.YAMAHA, "TH-4", Type.ACOUSTIC, 12,
                        Wood.ALDER, Wood.BASE));
        inventory.addGuitar("76531", 7749.6,
                new GuitarSpec(Builder.SAMSUNG, "TH-5", Type.CLASSIC, 6,
                        Wood.BASE, Wood.BASE));
        inventory.addGuitar("70108276", 3254.3,
                new GuitarSpec(Builder.SAMSUNG, "Th-6", Type.ACOUSTIC, 10,
                        Wood.BASE, Wood.ALDER));
    }

    public static void main(String[] args) {
        instance = new GuitarSearcherEnhanced();
        instance.initInventory();
        instance.searchGuitar();
    }

}
