@services
  Feature: Make request to service

    @GetImages
    Scenario: Make request to method Get for consult all images of cats
      Given I make the connection to the api
      When I Execute the method Get with the resource api "images/search?limit=10"
      Then I will see that the is returned 200

    #@GetAnImage
    #  Scenario: Make request to method Get for consult an image of cat
    #  Given I make the connection to the api
    #  When I Execute the method Get with the resource api "search/?id="
    #  Then I will see that the is returned 200



    @PostCreateFavourite
    Scenario Outline: Make request to method POST for create favorite an image of cat
      Given I make the connection to the api
      When I send the Id <image_id> with the method POST with the resource api "/favourites"
      Then I will see that the is returned 200
      And Check if the image create favourites successfully
      Examples:
      |image_id     |
      |"9ccXTANkb14"|
      |"9ccXTANkb15"|
      |"9ccXTANkb16"|
      |"9ccXTANkb17"|


    @GetImagesFavourites
    Scenario: Make request to method Get for cons
      Given I make the connection to the api
      When I Execute the method Get with the resource api "/favourites?sub_id=your-user-510"
      Then I will see that the is returned 200


    @PostUnHappy
    Scenario Outline:  I Make request to method POST for realice double favorite an image of cat
      Given I make the connection to the api
      When I send the Id <image_id> with <sub_id> for the method POST with the resource api "/favourites"
      Then I will see that the is returned 400
      And I will see the message <messagef>

      Examples:
        |image_id     |sub_id          | messagef |
        |"9ccXTANkb14"|"your-user-385" | "DUPLICATE_FAVOURITE - favourites are unique for account + image_id + sub_id" |


    @DeleteFavourite
    Scenario: Make request to method DELETE for delete an image of cat
      Given I make the connection to the api
      When Execute the method DELETE with the resource api "favourites/"
      Then I will see that the is returned 200
      Then Check if the image was delete successfully








