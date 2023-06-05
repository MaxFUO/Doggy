using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Skins : MonoBehaviour
{

    public GameObject animal;
    [Header("Sprite a Cambiar")]
    public SpriteRenderer parteCuerpoPerro;
    public SpriteRenderer parteCuerpoGato;

    [Header("Lista de Ropas")]
    public List<Sprite> listaRopa = new List<Sprite>();

    public int opcioncontador = 0;

    public void Siguiete()
    {
        opcioncontador++;
        if (opcioncontador >= listaRopa.Count)
        {
            opcioncontador = 0;
        }
        parteCuerpoPerro.sprite = listaRopa[opcioncontador];
        parteCuerpoGato.sprite = listaRopa[opcioncontador];
    }
    public void Anterior()
    {
        opcioncontador--;
        if (opcioncontador <= 0)
        {
            opcioncontador = listaRopa.Count - 1;
        }
        parteCuerpoPerro.sprite = listaRopa[opcioncontador];
        parteCuerpoGato.sprite = listaRopa[opcioncontador];
    }
    public void enviarPlayer(string nombreNivel)
    {
        PrefabUtility.SaveAsPrefabAsset(animal, "Assets/Prefabs/Animal.prefab");
        SceneManager.LoadScene(nombreNivel);
    }
}
