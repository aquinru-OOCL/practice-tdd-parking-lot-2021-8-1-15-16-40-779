# Story 1
[X] Case 1  
    Given a parking lot and a car  
    When parking a car  
    Then return a parking ticket

[X] Case 2  
    Given a parking lot with a parked car, and corresponding parking ticket  
    When fetching a car  
    Then return the car  

[X] Case 3  
    Given a parking lot with two parked cars, and two parking tickets  
    When fetching two cars  
    Then return the right car with corresponding ticket

[X] Case 4  
    Given in a parking lot and a wrong parking ticket  
    When fetching a car   
    Then return nothing  

[X] Case 5  
    Given in a parking lot and a used parking ticket  
    When fetching a car   
    Then return nothing  

[X] Case 6  
    Given in a parking lot and position is not available  
    When parking a car  
    Then return nothing 


# Story 2
[] Case 1  
    Given in a parking lot and a wrong parking ticket  
    When fetching a car  
    Then return nothing with error message "Unrecognized parking ticket."  

[] Case 2  
    Given in a parking lot and a used parking ticket  
    When fetching a car  
    Then return nothing with error message "Unrecognized parking ticket."

[] Case 3  
    Given in a parking lot and position is not available  
    When parking a car  
    Then return nothing with error message "No available position."