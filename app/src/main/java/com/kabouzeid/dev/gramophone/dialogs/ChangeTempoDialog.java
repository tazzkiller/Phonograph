package com.kabouzeid.dev.gramophone.dialogs;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kabouzeid.dev.gramophone.R;
import com.kabouzeid.dev.gramophone.helper.MusicPlayerRemote;
import com.kabouzeid.dev.gramophone.model.Song;
import com.kabouzeid.dev.gramophone.service.playback.Playback;
import com.kabouzeid.dev.gramophone.util.PlaylistsUtil;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (kabouzeid), Aidan Follestad (afollestad)
 */
public class ChangeTempoDialog extends DialogFragment {

    @NonNull
    public static ChangeTempoDialog create() {
        ChangeTempoDialog dialog = new ChangeTempoDialog();
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new MaterialDialog.Builder(getActivity())
                .title(R.string.change_tempo_title)
                .items(R.array.playback_speeds)
                .positiveText(R.string.action_set)
                .negativeText(android.R.string.cancel)
                .itemsCallbackSingleChoice(-1, (materialDialog, view, which, tempoChars) -> {
                    float tempoMultiplier = Float.parseFloat(tempoChars.toString());
                    Playback playback = MusicPlayerRemote.musicService.getPlayback();
                    playback.setTempo(tempoMultiplier);
                    return true;
                })
                .build();
    }
}
