use concessionaire;
db.cars.insert({
    "makes": [
        {
            "id": 200002038,
            "name": "Acura",
            "models": [
                {
                    "id": "Acura_ILX",
                    "name": "ILX",
                    "years": [
                        {
                            "id": 100538929,
                            "year": 2013,
                            "statuses": ["USED", "NEW"]
                        },
                        {
                            "id": 200471908,
                            "year": 2014,
                            "statuses": ["NEW"]
                        }
                    ],
                    "statuses": ["NEW", "USED"]
                }
            ]
        }
    ]
});