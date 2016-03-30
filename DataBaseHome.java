package csci230.dropdatabase;
import java.util.*;
import dblibrary.project.csci230.*;

public class DataBaseHome{
 // private UniversityDBLibrary database;
//private DataBase database;
private UniversityDBLibrary dummydatabase;
public DataBaseHome(){
  dummydatabase = new UniversityDBLibrary("dropdataba", "dropdataba", "ccmt4");
 // dummydatabase = data; 
}

public User login(String username, String password){
  String[][] users = dummydatabase.user_getUsers();
    for(int i=0; i< users.length ; i++){
      //System.out.println(users[i][2] + " " + users[i][3]);
       if(username.equals(users[i][2]) && password.equals(users[i][3]))
         return new User(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0),'a' );
  }
    return null;
}

public User addUser(String firstname, String lastname, String username, String password, char type){
  dummydatabase.user_addUser(firstname,lastname,username,password, type);
  return new User(firstname,lastname,username,password, type,'a');
}
    public ArrayList<User> getUsers(){
    String[][] temp = dummydatabase.user_getUsers();
    ArrayList<User> users = new ArrayList<User>();
    
    for(int i=0; i<temp.length;i++){
      users.add(new User(temp[i][0],temp[i][1],temp[i][2],temp[i][3],temp[i][4].charAt(0),temp[i][5].charAt(0)));
    }
      return users;
    }
    
    public User editUser(int id,String firstname, String lastname, String username, String password, char type,char status){
      dummydatabase.user_editUser(firstname,lastname,username,password, type,status);
      return new User(firstname,lastname,username,password,type,status);
    }
    
    public User deactivateUser(int id){
      String[][] temp = dummydatabase.user_getUsers();
      dummydatabase.user_editUser(temp[id][2],temp[id][0],temp[id][1],temp[id][3],temp[id][4].charAt(0),'d');
                  return new User(temp[id][0],temp[id][1],temp[id][2],temp[id][3],temp[id][4].charAt(0),'d');
    }
    
    public ArrayList<School> getSchools(){
      String[][] temp = dummydatabase.university_getUniversities();
      ArrayList<School> ret = new ArrayList<School>();
      
      for(int i=0; i<temp.length; i++){
        ret.add( new School(temp[i][16],temp[i][0],temp[i][1],temp[i][2],Integer.parseInt(temp[i][3]),Double.parseDouble(temp[i][4]),Double.parseDouble(temp[i][5]),
                            Double.parseDouble(temp[i][6]),Double.parseDouble(temp[i][7]),Double.parseDouble(temp[i][8]),Integer.parseInt(temp[i][9]),
                            Double.parseDouble(temp[i][10]),Double.parseDouble(temp[i][11]),Integer.parseInt(temp[i][12]),
                            Integer.parseInt(temp[i][13]),Integer.parseInt(temp[i][14]),temp[i][15].split(" ")));
      }
      return ret;
    }
   // Integer.parseInt(  Double.parseDouble(
                     
    public School getSchool(int id){
      String[][] temp = dummydatabase.university_getUniversities();
      return null;
    }
    
    public School editSchool(String school,String state, String location, String control, int numStudents, double percentFemale, double satVerbal, double satMath,
                           double expenses, double percentFinAid, int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale,
                           int socialScale, int qualOflife, String[] emphasis, int id){
      
   dummydatabase.university_editUniversity(school, state,location, control, numStudents, percentFemale, satVerbal, satMath,
      expenses, percentFinAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualOflife);
  
      String[][] temp = dummydatabase.university_getEmphases();
      for(int i=0; i<temp[id].length; i++){
       dummydatabase.university_removeUniversityEmphasis(school, temp[id][i]); 
      }
      for(int i=0; i<emphasis.length; i++){
       dummydatabase.university_addUniversityEmphasis(school, emphasis[i]); 
      }
      
      return new School(school,state,location,control,numStudents,satVerbal,satMath,numApplicants,
                        percentFemale,expenses,percentFinAid,percentAdmitted,percentEnrolled,
                        academicScale,socialScale,qualOflife,emphasis);
    }
  
    
}

