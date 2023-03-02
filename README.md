# Movie Data Store Application

This is a Java Springboot application providing a REST
API to save and search movie data. The format of the movie data is that of the following dataset: https://github.com/prust/wikipedia-movie-data

# REST API

The REST API app is described below.

## Add new movie data

### Request
`PUT /v1/save`

    curl -i -H 'Accept: application/json' http://localhost:8080/v1/save

    {
        "title": "Top Gun",
        "year": 1986,
        "cast": ["Tom Cruise", "Kelly McGillis"],
        "genres": ["Action"]
    }

### Response

    Status: 201 Created

## Update existing movie data

`PUT /v1/save`

    curl -i -H 'Accept: application/json' http://localhost:8080/v1/save

    {
        "title": "Top Gun",
        "year": 1986,
        "cast": ["Tom Cruise", "Kelly McGillis"],
        "genres": ["Action", "Adventure"]
    }

### Response

    Status: 200 OK

## Search based on title, year, cast member, or genre

### Request

`GET v1/search`

    curl -i -H 'Accept: application/json' http://localhost:8080/v1/search

    {
        "searchBy": "title",
        "value": "Mission Impossible"
    }

### Response

    Status: 200 OK

    [
        {
            "title": "Mission Impossible",
            "year": 1996,
            "cast": [
                "Tom Cruise",
                "Emmanuelle Beart"
            ],
            "genres": [
                "Action"
            ]
        }
    ]

### Request

`GET v1/search`

    curl -i -H 'Accept: application/json' http://localhost:8080/v1/search

    {
        "searchBy": "castMember",
        "value": "Tom Cruise"
    }

### Response

    Status: 200 OK

    [
        {
            "title": "Mission Impossible",
            "year": 1996,
            "cast": [
                "Tom Cruise",
                "Emmanuelle Beart"
            ],
            "genres": [
                "Action"
            ]
        },
        {
            "title": "Top Gun",
            "year": 1986,
            "cast": [
                "Tom Cruise",
                "Kelly McGillis"
            ],
            "genres": [
                "Action",
                "Adventure"
            ]
        }
        ...
    ]

### Request

`GET v1/search`

    curl -i -H 'Accept: application/json' http://localhost:8080/v1/search

    {
        "searchBy": "castMember",
        "value": "John Doe"
    }

### Response

    Status: 200 OK

    []

# Configuration

The application must be provided MySQL database information through a few environmental variables: DB_HOST, DB_PORT, DB_NAME, DB_USERNAME, DB_PASSWORD