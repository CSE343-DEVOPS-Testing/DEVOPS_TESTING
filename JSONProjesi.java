import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;


public class JSONProjesi {

    public class Response{
        public String title;
        public String type;
        public String description;

        public String prop_object_type;
        public String prop_operation;
        public String prop_status;
        public String prop_description;
        public String prop_project_name;

    }

    public class GeneralRequest
    {
        public String title;
        public String type;
        public String description;

        public String prop_object_type;
        public String prop_github_login;
        public String prop_github_password;
        public String prop_card_id;
        public String prop_repository_url;
        public String prop_project_name;
        public String prop_method;
    }

    public class MonitoringRequest
    {
        public String title;
        public String type;
        public String description;
        public String prop_object_type;
        public String prop_machine_info;
        public String prop_app_info;
        public String prop_method;
    }



    public JSONObject giveResponse(Response response)
    {
        try {
            JSONObject mainJson = new JSONObject();
            mainJson.put("title",response.title);
            mainJson.put("type",response.type);
            mainJson.put("description",response.description);


            JSONObject typeJson = new JSONObject();
            typeJson.put("type","string");
            JSONObject propJson = new JSONObject();
            propJson.put("object_type",typeJson);
            propJson.put("operation",typeJson);
            propJson.put("status",typeJson);
            propJson.put("description",typeJson);
            propJson.put("project_name",typeJson);


            mainJson.put("properties",propJson);

            return mainJson;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public MonitoringRequest getMonitoringRequest(JSONObject jsonObject)
    {
        MonitoringRequest mr =  new MonitoringRequest();

        try {
            mr.title = (String) jsonObject.get("type");
            mr.type = (String) jsonObject.get("title");
            mr.description  = (String) jsonObject.get("description");

            JSONObject propJson = (JSONObject) jsonObject.get("properties");
            mr.prop_object_type= (String) propJson.get("object_type");
            mr.prop_machine_info= (String) propJson.get("machine_info");
            mr.prop_app_info= (String) propJson.get("app_info");
            mr.prop_method= (String) propJson.get("method");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return mr;
    }
    public GeneralRequest getGeneralRequest(JSONObject jsonObject)
    {
        GeneralRequest gr = new GeneralRequest();
        try {
            gr.title =  (String) jsonObject.get("title");
            gr.type = (String) jsonObject.get("type");
            gr.description = (String) jsonObject.get("description");
            JSONObject propJson = (JSONObject) jsonObject.get("properties");
            gr.prop_object_type = (String) propJson.get("object_type");
            gr.prop_github_login = (String) propJson.get("github_login");
            gr.prop_github_password = (String) propJson.get("github_password");
            gr.prop_card_id = (String) propJson.get("card_id");
            gr.prop_repository_url= (String) propJson.get("repository_url");
            gr.prop_project_name = (String) propJson.get("project_name");
            gr.prop_method = (String) propJson.get("method");
        }catch (Exception e)
        {
          e.printStackTrace();
        }

        return gr;
    }



}