package com.example.marthakat.portsmouthcityguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ThingsToDoList extends AppCompatActivity {

    public TextView shops, museums, attractions, nightlife, hotels, pharmacy, service, hospitals, coffee, shopping, post, supermarket;
    public TextView atm, cinema, theatre, bank, library, gym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do_list);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //final Context context = this;
        shops = (TextView) findViewById(R.id.shops);
        shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showROnMap();
            }
        });

        museums = (TextView) findViewById(R.id.museums);
        museums.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showMOnMap();
            }
        });

        attractions = (TextView) findViewById(R.id.sightseeing);
        attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAOnMap();
            }
        });

        nightlife = (TextView) findViewById(R.id.nightlife);
        nightlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNOnMap();
            }
        });

        hotels = (TextView) findViewById(R.id.hotels);
        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHOnMap();
            }
        });

        pharmacy = (TextView) findViewById(R.id.pharmacy);
        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPOnMap();
            }
        });

        service = (TextView) findViewById(R.id.services);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSOnMap();
            }
        });

        hospitals = (TextView) findViewById(R.id.hospital);
        hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMCOnMap();
            }
        });

        coffee = (TextView) findViewById(R.id.coffeeS);
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCSOnMap();
            }
        });

        shopping = (TextView) findViewById(R.id.shopping);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShOnMap();
            }
        });

        post = (TextView) findViewById(R.id.postOffice);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPostOnMap();
            }
        });

        supermarket = (TextView) findViewById(R.id.supermarket);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSMOnMap();
            }
        });

        atm = (TextView) findViewById(R.id.atm);
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showATMOnMap();
            }
        });

        cinema = (TextView) findViewById(R.id.cinema);
        cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCinemaOnMap();
            }
        });

        theatre = (TextView) findViewById(R.id.theatre);
        theatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheatreOnMap();
            }
        });

        bank = (TextView) findViewById(R.id.bank);
        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBankOnMap();
            }
        });

        library = (TextView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLibraryOnMap();
            }
        });

        gym = (TextView) findViewById(R.id.gym);
        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGymOnMap();
            }
        });
    }

    public void showAOnMap() {
        // Search for attractions in Portsmouth
        System.out.println("Searching for attractions now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=attractions");
        //geo:50.814266, -1.071873 -> coordinates for Portsmouth, z=12 -> zoom, q=attractions -> query
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showROnMap() {
        // Search for restaurants in Portsmouth
        System.out.println("Searching for restaurants now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showMOnMap() {
        // Search for museums in Portsmouth
        System.out.println("Searching for museums now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=museums");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showNOnMap() {
        // Search for nightlife in Portsmouth
        System.out.println("Searching for nightlife now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=nightlife");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showHOnMap() {
        // Search for hotels in Portsmouth
        System.out.println("Searching for hotels now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=hotels");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showPOnMap() {
        // Search for pharmacy in Portsmouth
        System.out.println("Searching for pharmacy now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=pharmacy");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showSOnMap() {
        // Search for services in Portsmouth
        System.out.println("Searching for services now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=police");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showMCOnMap() {
        // Search for hospitals in Portsmouth
        System.out.println("Searching for hospitals now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=medical");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showCSOnMap() {
        // Search for coffee shops in Portsmouth
        System.out.println("Searching for coffee shops now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=coffee shops");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showShOnMap() {
        // Search for shopping center in Portsmouth
        System.out.println("Searching for shopping center now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=shopping");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showPostOnMap() {
        // Search for post office in Portsmouth
        System.out.println("Searching for post office now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=post office");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showSMOnMap() {
        // Search for supermarket in Portsmouth
        System.out.println("Searching for supermarket now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=supermarket");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showATMOnMap() {
        // Search for atm in Portsmouth
        System.out.println("Searching for atm now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=atm");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showCinemaOnMap() {
        // Search for cinema in Portsmouth
        System.out.println("Searching for cinema now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=cinema");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showTheatreOnMap() {
        // Search for theatre in Portsmouth
        System.out.println("Searching for theatre now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=theatre");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showBankOnMap() {
        // Search for banks in Portsmouth
        System.out.println("Searching for banks now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=bank");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showLibraryOnMap() {
        // Search for library in Portsmouth
        System.out.println("Searching for library now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=library");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showGymOnMap() {
        // Search for gym in Portsmouth
        System.out.println("Searching for gym now...");
        Uri gmmIntentUri = Uri.parse("geo:50.814266, -1.071873?z=12&q=gym");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void goBack(View v){
        ThingsToDoList.this.onBackPressed();
    }
}
