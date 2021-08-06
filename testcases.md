# Story 1
[X] Case 1  
    Given a parking lot and a car  
    When parking a car  
    Then return a parking ticket

[] Case 2  
    Given a parking lot with a parked car, and corresponding parking ticket  
    When fetching a car  
    Then return the car  

[] Case 3  
    Given a parking lot with two parked cars, and two parking tickets  
    When fetching both cars  
    Then return the right car with corresponding ticket

[] Case 4  
    Given in a parking lot and a wrong parking ticket  
    When fetching a car   
    Then return nothing  

[] Case 5  
    Given in a parking lot and a used parking ticket  
    When fetching a car   
    Then return nothing  

[] Case 6  
    Given in a parking lot and position is not available  
    When parking a car  
    Then return nothing  