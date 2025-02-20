package com.keneth.hymnbook

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class HymnsViewModel: ViewModel() {

    private val _hymnState =mutableStateOf(HymnsViewState())
    val hymnState : State<HymnsViewState> = _hymnState

    fun onHymnSelected(hymn: Hymn){
        _hymnState.value = _hymnState.value.copy(selectedHymn = hymn)

        viewModelScope.launch {


        }

    }












    data class HymnsViewState(
        val hymns: List<Hymn> = emptyList(),
        val selectedHymn: Hymn? = null
    )



}