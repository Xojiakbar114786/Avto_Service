package brr.uz.avto_service.fireBase;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class SendMessage {

    public void notifocation(String title,String message, int id){
        NotificationTest body = new NotificationTest();
        body.setTo("/topics/salom");
        body.setDatas(new Datas(title,message,id));
        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "key=" + "AAAANjDJ9IA:APA91bGKP_eiCBv9IpiYTeJFWej5rvTdjCqjnkeXwzfhndXX5B38TYgSmav5wrTK9VNtnBLGBlv-wvLbnwVMr7dDAEuHkMDM5rOUueMpnoKy09eBWBgGfDxZ_FpMwSkbhckq_4QiDNmI" + "");
        String url = "https://fcm.googleapis.com/fcm/send";
        RestTemplate template = new RestTemplate();
        HttpEntity<NotificationTest> entity = new HttpEntity<>(body, headers);
        template.postForLocation(url, entity);
        System.out.println("send mew message");
    }
}
