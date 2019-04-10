package Domain;

public class EventValidator {

    /**
     * validates an event
     * @param event to validate
     * @throws EventValidatorException if there are validation errors
     */
    public void validate(Event event){
        String duration = event.getDuration();
       // String starthour = event.getStarthour();

        String errors="";

        if(duration.length()!=0){
            errors+="The duration format should be 00.00\n";
        }

        if(duration.charAt(2) != '.' || duration.charAt(5) != '.'){
            errors+="Hour format should be 00.00\n";
        }

        if(!errors.isEmpty()){
            throw new EventValidatorException(errors);
        }
    }
}
