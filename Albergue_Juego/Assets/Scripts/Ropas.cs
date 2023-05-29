using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Ropas : MonoBehaviour
{

    public GameObject player;
    [Header("Sprite a Cambiar")]
    public SpriteRenderer parteCuerpo;

    [Header("Lista de Ropas")]
    public List<Sprite> listaRopa = new List<Sprite>();

    public int opcioncontador = 0;

    void Update(){
        parteCuerpo.sprite = listaRopa[opcioncontador];
    }
    public void Siguiete()
    {
        opcioncontador++;
        if (opcioncontador >= listaRopa.Count)
        {
            opcioncontador = 0;
        }
        parteCuerpo.sprite = listaRopa[opcioncontador];
    }
    public void Anterior()
    {
        opcioncontador--;
        if (opcioncontador <= 0)
        {
            opcioncontador = listaRopa.Count - 1;
        }
        parteCuerpo.sprite = listaRopa[opcioncontador];
    }
    public void enviarPlayer(string nombreNivel)
    {
        PrefabUtility.SaveAsPrefabAsset(player, "Assets/Prefabs/Animal.prefab");
        SceneManager.LoadScene(nombreNivel);
    }
}
