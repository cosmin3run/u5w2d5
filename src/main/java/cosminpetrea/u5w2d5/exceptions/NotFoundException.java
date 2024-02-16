package cosminpetrea.u5w2d5.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){super(message);}

    public NotFoundException(UUID id){super(id + " has not been found");}
}
