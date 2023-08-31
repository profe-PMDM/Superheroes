package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.model.HeroesRepository.heroes


@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
) {
    LazyColumn() {
        items(heroes) { hero ->
            HeroItem(
                hero,
                modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.clip(MaterialTheme.shapes.medium)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.name),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(id = hero.description),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier
                    .clip(MaterialTheme.shapes.small)
                    .size(72.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = hero.imageResourceId),
                    contentDescription = stringResource(id = hero.description),
                )
            }
        }
    }
}

@Preview
@Composable
fun HeroItemPreview() {
    HeroItem(hero = heroes[0])
}