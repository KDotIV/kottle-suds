package com.kottle-suds.graphsudoku.ui.newgame.buildlogic

import android.content.Context
import com.kottle-suds.graphsudoku.common.ProductionDispatcherProvider
import com.kottle-suds.graphsudoku.persistence.*
import com.kottle-suds.graphsudoku.ui.newgame.NewGameContainer
import com.kottle-suds.graphsudoku.ui.newgame.NewGameLogic
import com.kottle-suds.graphsudoku.ui.newgame.NewGameViewModel

internal fun buildNewGameLogic(
    container: NewGameContainer,
    viewModel: NewGameViewModel,
    context: Context
): NewGameLogic {
    return NewGameLogic(
        container,
        viewModel,
        GameRepositoryImpl(
            LocalGameStorageImpl(context.filesDir.path),
            LocalSettingsStorageImpl(context.settingsDataStore)
        ),
        LocalStatisticsStorageImpl(
            context.statsDataStore
        ),
        ProductionDispatcherProvider
    )
}