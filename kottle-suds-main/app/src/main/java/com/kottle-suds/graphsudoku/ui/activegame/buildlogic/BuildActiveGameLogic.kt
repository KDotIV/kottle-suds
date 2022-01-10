package com.kottle-suds.graphsudoku.ui.activegame

import android.content.Context
import com.kottle-suds.graphsudoku.common.ProductionDispatcherProvider
import com.kottle-suds.graphsudoku.persistence.*


internal fun buildActiveGameLogic(
    container: ActiveGameContainer,
    viewModel: ActiveGameViewModel,
    context: Context
): ActiveGameLogic {
    return ActiveGameLogic(
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