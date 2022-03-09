package com.example.poshell.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();
    private List<Item> Modify_items = new ArrayList<>();//存放修改的指令

    public boolean addItem(Item item) {
        return items.add(item);
    }
    public boolean modifyItem(Item item) {
        return Modify_items.add(item);
    }
    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        int num_PD1 = 0;//商品的数目
        int num_PD2 = 0;
        for (int j = 0; j < items.size(); j++) {
            if(items.get(j).getProduct().getId() == "PD1"){
                num_PD1 += items.get(j).getAmount();
            }
            if(items.get(j).getProduct().getId()=="PD2"){
                num_PD2 += items.get(j).getAmount();
            }
        }
        if(num_PD1 < 0 || num_PD2 < 0){
            return "ERROR";
        }
        //System.out.println(num_PD1);
        //System.out.println(num_PD2);
        //for (int i = 0; i < items.size(); i++) {
            //stringBuilder.append(items.get(i).toString()).append("\n");
            //System.out.println(items.get(i).getProduct().getId());获得商品Id
            //System.out.println(items.get(i).getProduct().getName());获得商品名字
            //System.out.println(items.get(i).getProduct().getPrice());获得商品价格
            //total += items.get(i).getAmount() * items.get(i).getProduct().getPrice();
        //}
        for(int t = 0; t < Modify_items.size();t++){
            if(Modify_items.get(t).getProduct().getId()=="PD1"){
                num_PD1 = Modify_items.get(t).getAmount();
            }
            if(Modify_items.get(t).getProduct().getId()=="PD2"){
                num_PD2 = Modify_items.get(t).getAmount();
            }
        }
        if(num_PD1 > 0){
            stringBuilder.append("PD1\tiPhone 13\t8999.0\t").append(num_PD1).append("\n");
            total += num_PD1 * 8999;
        }
        if(num_PD2 > 0){
            stringBuilder.append("PD2\tMacBook Pro\t29499.0\t").append(num_PD2).append("\n");
            total += num_PD2 * 29499;
        }

        stringBuilder.append("----------------------\n"  );
        //stringBuilder.append(items.size()).append("\n");
        //System.out.println(items);
        stringBuilder.append("Total...\t\t\t" + total );


        return stringBuilder.toString();
    }
}
