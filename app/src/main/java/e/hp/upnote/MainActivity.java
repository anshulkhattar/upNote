package e.hp.upnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etInput;
    TextView txtText;
    Button btnAdd, btnDelete,btnView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.addButton);
        btnDelete = (Button)findViewById(R.id.deleteButton);
        etInput = (EditText)findViewById(R.id.enterText);
        //txtText = (TextView)findViewById(R.id.savedText);
        btnView=(Button)findViewById(R.id.viewButton);
        dbHandler = new MyDBHandler(this, null, null, 1);

    btnView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i= new Intent(MainActivity.this,ViewListContent.class);
            startActivity(i);
        }
    });
    }

    //Add a product to the database
    public void addButtonClicked(View view) {
        Log.i("exxxx", "CLİCKED ADD BUTTON");
        String product = etInput.getText().toString();
        Products p = new Products(product);
        dbHandler.addProduct(p);
    }

    //Delete a product to the database
    public void deleteButtonClicked(View view){
        Log.i("exxxx", "CLİCKED DELETE BUTTON");
        String inputText = etInput.getText().toString();
        dbHandler.deleteProduct(inputText);
    }
}