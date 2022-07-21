package jp.ac.titech.itpro.sdl.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;

import jp.ac.titech.itpro.sdl.map.model.EntryExit;
import jp.ac.titech.itpro.sdl.map.model.ViewModel;

public class Data extends Fragment {
    private ViewModel viewModel;

    public Data(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_data, container, false);
        TableLayout tableLayout = rootView.findViewById(R.id.dataTable);
        for (EntryExit entryExit : viewModel.entryExitList) {
            TableRow tableRow = new TableRow(getContext());
            TextView place = new TextView(getContext());
            TextView entry = new TextView(getContext());
            TextView exit = new TextView(getContext());
            place.setText(entryExit.name);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm");
            entry.setText("");
            exit.setText("");
            switch (entryExit.entoryOrExit) {
                case ENTRY:
                    entry.setText(dateFormat.format(entryExit.time));
                    break;
                case EXIT:
                    exit.setText(dateFormat.format(entryExit.time));
                    break;
                default:
                    break;
            };
            TableRow.LayoutParams rowLayout = new TableRow.LayoutParams();
            rowLayout.weight = 1;
            tableRow.addView(place, rowLayout);
            tableRow.addView(entry, rowLayout);
            tableRow.addView(exit, rowLayout);
            tableLayout.addView(tableRow);
        }
        return rootView;
    }
}
