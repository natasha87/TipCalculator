package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);

		final Button btnCalculate = (Button)findViewById(R.id.btnCalculate); 
		final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
		final EditText edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		final TextView txtTipResult = (TextView)findViewById(R.id.txtTipResult);

		btnCalculate.setOnClickListener( 
				new OnClickListener() { 
					@Override
					public void onClick(View v) {
						String input = edtBillAmount.getText().toString();
						if (chkRound.isChecked()) {
							try{
								int bill = Integer.parseInt(input);	
								int tip = (int)Math.round(bill*0.12);
								txtTipResult.setText("Tip: $" + tip);
							}
							catch (Exception e){
								float bill = Float.parseFloat(input);
								double tip = bill*0.12;
								txtTipResult.setText("Tip: $" + (int)Math.round(tip));
							}

						}
						else {
							float bill = Float.parseFloat(input);
							txtTipResult.setText("Tip: $" + String.format("%.2f", bill*0.12));
						}
					} 
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);

		return true;
	}

}
