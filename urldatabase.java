
import java.util.*;
import java.util.stream.*;

import javax.lang.model.util.ElementScanner6;

class DataBase{

    int shortKey;
    int usageCount;
    String url;

    //Getter and Setter
    void setShortKey(int sk){
        shortKey=sk;
    }
    int getShortKey(){
        return this.shortKey;
    }
    void setUsageCount(int uk){
        usageCount=uk;
    }
    int getUsageCount(){
        return usageCount;
    }
    void setUrl(String url){
        this.url=url;
    }
    String getUrl(){
        return this.url;
    }


}


class List{

    ArrayList<DataBase> table = new ArrayList<DataBase>();
    int key=0;
   
    void storeUrl(String url){
        if(url.length()==0)
            System.out.println("Url not found! \n");
        else{
            //Generating unique key
            key++;
            DataBase urldata=new DataBase();
            urldata.setUrl(url);
            urldata.setShortKey(key);
            urldata.setUsageCount(0);
            table.add(urldata);
            //System.out.println("\n");
        }
    }

    void getShortKey(String url){
        DataBase urldata=new DataBase();
        int found=0;
        for(int itr=0;itr<table.size();itr++){
            urldata=table.get(itr);
            if(urldata.getUrl().equals(url)){
                found=1;
                //incrementing usage count;
                urldata.setUsageCount(urldata.getUsageCount()+1);
                System.out.println(urldata.shortKey+"\n");
               
            }
        }
        //invalid url
        if(found==0)
         System.out.println("Url not found! \n");

    }

    void getCount(String url){

        DataBase urldata=new DataBase();
        boolean found=false;
        for(int itr=0;itr<table.size();itr++){
            urldata=table.get(itr);
            if(urldata.getUrl().equals(url)){
                found=true;
                System.out.println(urldata.getUsageCount()+"\n"); 
                break;
            }
        }
        if(found==false)
        System.out.println("Url not found! \n");
        
    }

    void listUrl(){
        if(table.size()!=0){

            
            System.out.println("{\n");
            table.stream().forEach((x)->System.out.println("[\n key: "+x.shortKey+" \nUsage_count: "+x.usageCount+"\nUrl:"+ x.url+"\n],"));
           System.out.println("\n}");
   
    
    }
        else
            System.out.println("Table empty!\n");
    }

    

}

class urldatabase{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List lst=new List();
        String url="";
        String command="";
        
        System.out.println("Enter any of the following command with url \n");
        boolean flag=true;
        while(flag==true){
            System.out.println("1.storeurl\n"+"2.get\n"+"3.count\n"+"4.List\n"+"5.exit\n");
            String commandUrl=sc.nextLine();
            System.out.println("\n");
            String[] inputs=commandUrl.split(" ");
            if(inputs.length<=2){
              
                    command=inputs[0];
                    if(inputs.length==2){
                    url=inputs[1];                    
                }
                
                switch(command){
                    case "storeurl":lst.storeUrl(url);
                    break;
                    case "list":lst.listUrl();
                    break;
                    case "get":lst.getShortKey(url);
                    break;
                    case "count":lst.getCount(url);
                    break;
                    case "exit":flag=false;
                    break;
                    default:System.out.println("invalid command\n");
                }
                url="";
                
            }
            else{
                System.out.println("invalid command or url");
            }
    }
    }
}