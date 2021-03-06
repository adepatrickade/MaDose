package com.example.hp.madose;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Acceuil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private BaseDeDonne bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bd = new BaseDeDonne(this);


if(!bd.checkIfTableHasData("Besoins_Sortie") && !bd.checkIfTableHasData("Categorie") && !bd.checkIfTableHasData("Demande") && !bd.checkIfTableHasData("Demande_Besoins") && !bd.checkIfTableHasData("Departement") && !bd.checkIfTableHasData("Employe") && !bd.checkIfTableHasData("Besoin") && !bd.checkIfTableHasData("Besoins_Entree") && !bd.checkIfTableHasData("Entree") && !bd.checkIfTableHasData("Fournisseur") && !bd.checkIfTableHasData("Sortie")) 
             {
    bd.insertCat("MATERIEL DE BUREAU");
    bd.insertCat("OUTIL INFORMATIQUE");
    bd.insertCat("MATERIEL DE CUISINE");
    bd.insertCat("MATERIEL D ENTRETIENT");
    bd.insertCat("OUTIL PAUSE CAFE");

    bd.insert("INFORMATIQUE");
    bd.insert("RECHERCHE");
    bd.insert("SECRETARIAT");
    bd.insert("DIRECTION");

    bd.insertBesoin("STYLO", "non amortissable", 1, 3, "0", 2);
    bd.insertBesoin("MARKER", "non amortissable", 1, 2, "0", 0);
    bd.insertBesoin("BALAI", "non amortissable", 4, 2, "0", 0);
    bd.insertBesoin("PAPIER RAM", "non amortissable", 1, 3, "0", 2);
    bd.insertBesoin("CAHIER", "non amortissable", 1, 2, "0", 0);
    bd.insertBesoin("ORDINATEUR", "amortissable", 2, 0, "2020-03-25", 0);
    bd.insertBesoin("IMPRIMANTE", "amortissable", 2, 0, "2020-03-25", 0);

    bd.insertFour("CASH CENTER", "01 bp 4236 Abidjan 01", 22445623);
    bd.insertFour("CASH IVOIRE", "01 bp 4036 Abidjan 02", 22441683);
    bd.insertFour("CDCI", "01 bp 1250 Abidjan 10", 22441182);
    bd.insertFour("SOCOCE", "01 bp 4036 Abidjan 28", 22441683);

    bd.insertEmp("Eric KOUADJO", 1, "ADMIN");
    bd.insertEmp("Patrick ADEJINLE", 1, "ADMIN");
    bd.insertEmp("Myriame KONE", 2, "ADMIN");
    bd.insertEmp("Seydou KONE", 2, "ADMIN");
    bd.insertEmp("Yvon LAGO", 2, "ADMIN");
    bd.insertEmp("Bénédicte ASSOH EPSE YAPI", 3, "ADMIN");

    bd.insertEntr("2018-01-02", 1);
    bd.insertEntr("2018-01-02", 4);


    bd.insertEntrBes(1, 1, 150, 5, "Bic", "bleu");
    bd.insertEntrBes(2, 1, 250, 5, "Bic", "noir, permanent");
    bd.insertEntrBes(6, 2, 450000, 5, "HP", "noir, core i5, portable");
    bd.insertEntrBes(4, 2, 250000, 5, "HP Laser", "blanc");
    bd.insertEntrBes(5, 1, 500, 3, "PRIVILEGE", "200 pages");

    bd.insertDemande("2018-01-02", 1, 1);
    bd.insertDemandeBesoin(1, 1, 1);
    bd.insertDemandeBesoin(1, 6, 1);
    MyApplication.setFetch(false);
}


        bd.RupureCheck();
        if (MyApplication.isDone() && !MyApplication.isCheck()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Acceuil.this);
            builder.setMessage("Certains de vos articles sont en rupture");
            builder.setTitle("Rupture");
            builder.setPositiveButton("Voir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    MyApplication.setCheck(true);
                    Intent intent=new Intent(Acceuil.this,Affichage.class);
                    intent.putExtra("passage","Rupture_original");
                    startActivity(intent);
                }
            });
            builder.create();
            builder.show();
        }


        ImageButton imageButton = (ImageButton) findViewById(R.id.imageB1);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageB);
        ImageButton imageButton2=(ImageButton)findViewById(R.id.imageButton);
        ImageButton imageButton3=(ImageButton)findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceuil.this, Add.class);
                startActivity(intent);
            }
        });


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceuil.this, BringOut.class);
                startActivity(intent);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceuil.this, Demande.class);
                startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceuil.this, Variation.class);
                startActivity(intent);
            }
        });







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acceuil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.employé:
                Intent c = new Intent(Acceuil.this, Employe.class);
                startActivity(c);
                break;
            case R.id.fournisseur:
                Intent g = new Intent(Acceuil.this, Fournisseur.class);
                startActivity(g);
                break;
            case R.id.departement:
                Intent p = new Intent(Acceuil.this, Departement.class);
                startActivity(p);
                break;
            case R.id.categorie:
                Intent k = new Intent(Acceuil.this, Categorie.class);
                startActivity(k);
                break;
            case R.id.besoin:
                Intent b = new Intent(Acceuil.this, Besoin.class);
                startActivity(b);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Acceuil Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
